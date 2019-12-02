package com.fly.repository;

import com.fly.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    Channel findById(Integer id);

    @Query(value = "SELECT c.* from channel c where c.subchannel_id is null", nativeQuery = true)
    List<Channel> findBySubchannelIsNull();

}
