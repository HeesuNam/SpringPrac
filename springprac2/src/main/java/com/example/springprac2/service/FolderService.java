package com.example.springprac2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springprac2.model.Folder;
import com.example.springprac2.model.Product;
import com.example.springprac2.model.User;
import com.example.springprac2.repository.FolderRepository;
import com.example.springprac2.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FolderService {

    private final FolderRepository folderRepository;
    private final ProductRepository ProductRepository;

    @Autowired
    public FolderService(FolderRepository folderRepository, ProductRepository ProductRepository) {
        this.folderRepository = folderRepository;
        this.ProductRepository = ProductRepository;
    }

    // 로그인한 회원에 폴더들 등록
    public List<Folder> addFolders(List<String> folderNames, User user) {
        List<Folder> folderList = new ArrayList<>();
        for (String folderName : folderNames) {
            Optional<Folder> existFolderChk = folderRepository.findByName(folderName);
            if (!existFolderChk.isPresent()) {
                Folder folder = new Folder(folderName, user);
                folderList.add(folder);
            }
        }

        return folderRepository.saveAll(folderList);
    }

    // 로그인한 회원이 등록된 모든 폴더 조회
    public List<Folder> getFolders(User user) {
        return folderRepository.findAllByUser(user);
    }

    public Page<Product> getProductsInFolder(
            Long folderId,
            int page,
            int size,
            String sortBy,
            boolean isAsc,
            User user) {
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        return ProductRepository.findAllByUserIdAndFolderList_Id(user.getId(), folderId, pageable);
    }
}