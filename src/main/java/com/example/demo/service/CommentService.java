package com.example.demo.service;

import com.example.demo.repository.CommentRepository;
import com.example.demo.web.Request.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    //     private final CommentRepository commentRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long save(CommentSaveRequestDto requestDto) {
        return commentRepository.save(requestDto.toEntity()).getId(); //바로 db에저장된다!
        //하지만 직접만든 레포지토리는 1차캐시에만 저장되는듯?... getId가안불러짐 ㄷㄷ
    }

}