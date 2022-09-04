package com.example.springprac2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springprac2.model.Folder;
import com.example.springprac2.model.User;

public interface FolderRepository extends JpaRepository<Folder, Long> {

    List<Folder> findAllByUser(User user);

    Optional<Folder> findByName(String folderName);

}
