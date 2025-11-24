package com.example.meme.memeproject.repositories;

import com.example.meme.memeproject.models.MemeItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeItemRepository extends CrudRepository <MemeItem, Long>{
}

