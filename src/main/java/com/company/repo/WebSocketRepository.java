package com.company.repo;

import com.company.model.WebSocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebSocketRepository extends JpaRepository<WebSocket, Long>{
    @Query("select t.content from WebSocket t")
    List<String> find();

}
