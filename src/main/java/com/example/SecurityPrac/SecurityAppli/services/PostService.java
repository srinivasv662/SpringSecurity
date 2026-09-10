package com.example.SecurityPrac.SecurityAppli.services;

import com.example.SecurityPrac.SecurityAppli.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO inputPost);

    PostDTO getPostById(Long postId);
}
