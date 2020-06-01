package com.example.shiro.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/7/31.
 */
@Service
public class RedisSessionDao extends AbstractSessionDAO {
    /**
     *  Session超时时间，单位为毫秒
     */
    private static Logger logger = LoggerFactory.getLogger(RedisSessionDao.class);
    private long expireTime = 30*60*1000;
    /**
     * Redis操作类，对这个使用不熟悉的，可以参考前面的博客
     */
    @Autowired
    private RedisTemplate redisTemplate;

    public RedisSessionDao() {
        super();
    }

    public RedisSessionDao(long expireTime, RedisTemplate redisTemplate) {
        super();
        this.expireTime = expireTime;
        //Long类型不可以会出现异常信息;
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        this.redisTemplate = redisTemplate;
    }

    /**
     * 更新session
     * @param session
     * @throws UnknownSessionException
     */
    @Override
    public void update(Session session) throws UnknownSessionException {
        if (session == null || session.getId() == null) {
            return;
        }
        session.setTimeout(expireTime);
        redisTemplate.opsForValue().set(session.getId(), session, expireTime, TimeUnit.MILLISECONDS);
    }

    /**
     * 删除session
     * @param session
     */
    @Override
    public void delete(Session session) {
        if (null == session) {
            return;
        }
        redisTemplate.opsForValue().getOperations().delete(session.getId());
    }


    /**
     * // 获取活跃的session，可以用来统计在线人数，如果要实现这个功能，
     * 可以在将session加入redis时指定一个session前缀，统计的时候则使用keys("session-prefix*")的方式来模糊查找redis中所有的session集合
     * @param
     * @return
     */
    @Override
    public Collection<Session> getActiveSessions() {
        Set keys = redisTemplate.keys("*");
        Collection<Session> activeSessions = new ArrayList<>();
        for (Object o:keys){
            String sessionId = o.toString();
            if(sessionId.equals("SuiteTicket") || sessionId.equals("suite_access_token")){
                continue;
            }
            Session session = (Session) redisTemplate.opsForValue().get(sessionId);
            activeSessions.add(session);
        }
        return activeSessions;
    }

    /**
     * 加入session
     * @param session
     * @return
     */
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        //Long类型不可以会出现异常信息;
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        redisTemplate.opsForValue().set(session.getId(), session, expireTime, TimeUnit.MILLISECONDS);
        return sessionId;
    }

    /**
     * 读取session
     * @param sessionId
     * @return
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            return null;
        }
        return (Session) redisTemplate.opsForValue().get(sessionId);
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        //Long类型不可以会出现异常信息;
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        this.redisTemplate = redisTemplate;

    }
}