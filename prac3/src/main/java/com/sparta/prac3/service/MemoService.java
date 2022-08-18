package com.sparta.prac3.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sparta.prac3.domain.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional // DB에 실행되어야한다고 알려줌
    public Long update(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 없습니다."));
        memo.update(memoRequestDto);
        return id;
    }

}
