package com.example.repository.jpa;

import com.example.model.ShowColumnModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author tanghh
 * @Date 2020/5/29 15:26
 */
public interface ShowColumnJPARepository  extends JpaRepository<ShowColumnModel, Integer>, JpaSpecificationExecutor<ShowColumnModel> {


}
