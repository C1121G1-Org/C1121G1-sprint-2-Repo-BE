package api.controllers;

import api.dto.CommentDto;
import api.dto.LikeCmtAndGuest;
import api.dto.LikeCommentDto;
import api.models.*;
import api.repositories.ICommentRepository;
import api.services.ICommentService;
import api.services.IGuestService;
import api.services.ILikeCommentService;
import api.services.IPostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/comment")
public class CommentRestController {
    @Autowired
    ICommentService iCommentService;
    @Autowired
    ILikeCommentService iLikeCommentService;
    @Autowired
    IPostService iPostService;
    @Autowired
    IGuestService iGuestService;

         /*  Created by hoangDH
           Role: Admin, member
           Time: 11:17 24/06/2022
           Function: create comment;
           Class:*/

    @Transactional(rollbackFor = Exception.class)
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createComment(@Valid @RequestBody CommentDto commentDto, BindingResult bindingResult) {
        commentDto.validate(commentDto, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        bindingResult
                .getFieldErrors()
                .stream()
                .forEach(
                        fieldError -> {
                            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                        });
        // Print log errors
        if (bindingResult.hasErrors()) {
            for (Map.Entry<String, String> entry : errorMap.entrySet()) {
                System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
            }
        }
        if (!bindingResult.hasErrors()) {
            try {
                // Add new Comment
                Post post = iPostService.findPostById1(commentDto.getPost_id());
                Guest guest = iGuestService.findGuestById(commentDto.getGuest_id());
                if (post == null || guest == null) {
                    return new ResponseEntity<>(new ResponseObject<>(false, "FAILED TO FIND GUEST OR POST", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
                } else {
                    Comment comment = new Comment();
                    comment.setCommentContent(commentDto.getCommentContent());
                    comment.setTime(commentDto.getTime());
                    comment.setGuest(guest);
                    comment.setPost(post);
                    iCommentService.createComment(comment);
                    return new ResponseEntity<>(new ResponseObject<>(true, "OK", errorMap, new ArrayList<>()), HttpStatus.OK);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new ResponseEntity<>(new ResponseObject<>(false, "FAILED", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Comment>> listCommentByPostId(@RequestParam(name = "id") Long id) {
        Post post = iPostService.findPostById1(id);
        List<Comment> commentList;
        if (post != null) {
            commentList = iCommentService.listCommentByPostId(id);
            return new ResponseEntity<>(commentList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/countComment")
    public ResponseEntity<Long> countCommentByPostId(@RequestParam(name = "id") Long id) {
        Post post = iPostService.findPostById1(id);
        Long countComment;
        if (post != null) {
            countComment = iCommentService.countCommentByPostId(id);
            return new ResponseEntity<>(countComment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional(rollbackFor = Exception.class)
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateComment(@Valid @RequestBody CommentDto commentDto
            , BindingResult bindingResult, @PathVariable(name = "id") Long id) {
        commentDto.validate(commentDto, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        bindingResult
                .getFieldErrors()
                .stream()
                .forEach(
                        fieldError -> {
                            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                        });
        // Print log errors
        if (bindingResult.hasErrors()) {
            for (Map.Entry<String, String> entry : errorMap.entrySet()) {
                System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
            }
        }
        if (!bindingResult.hasErrors()) {
            try {
                // Add new Comment
                Post post = iPostService.findPostById1(commentDto.getPost_id());
                Guest guest = iGuestService.findGuestById(commentDto.getGuest_id());
                if (post == null || guest == null) {
                    return new ResponseEntity<>(new ResponseObject<>(false, "FAILED TO FIND GUEST OR POST", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
                } else {
                    Comment comment = new Comment();
                    comment.setCommentContent(commentDto.getCommentContent());
                    comment.setTime(commentDto.getTime());
                    comment.setGuest(guest);
                    comment.setPost(post);
                    iCommentService.updateCommentById(comment, id);
                    return new ResponseEntity<>(new ResponseObject<>(true, "OK", errorMap, new ArrayList<>()), HttpStatus.OK);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new ResponseEntity<>(new ResponseObject<>(false, "FAILED", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        Comment comment = iCommentService.findCommentById(id);
        if (comment != null) {
            iCommentService.deleteCommentById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Like comment


    @GetMapping(value = "/countLikeComment")
    public ResponseEntity<Long> countLikeCommentByCommentId(@RequestParam(name = "id") Long id) {
        Comment comment = iCommentService.findCommentById(id);
        Long countLikeComment;
        if (comment != null) {
            countLikeComment = iLikeCommentService.countLikeCommentById(id);
            return new ResponseEntity<>(countLikeComment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/listLikeComment")
    public ResponseEntity<List<LikeCmtAndGuest>> listLikeCommentByCommentId(@RequestParam(name = "id") Long id) {
        Comment comment = iCommentService.findCommentById(id);
        List<LikeCmtAndGuest> commentList;
        if (comment != null) {
            commentList = iLikeCommentService.listLikeComment(id);
            return new ResponseEntity<>(commentList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping(value = "/updateOrCreateLikeCmt")
    public ResponseEntity<ResponseObject> updateAndCreateLikeCmt(@Valid @RequestBody LikeCommentDto likeCommentDto
            , BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap<>();
        bindingResult
                .getFieldErrors()
                .stream()
                .forEach(
                        fieldError -> {
                            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                        });

        // Print log errors
        if (bindingResult.hasErrors()) {
            for (Map.Entry<String, String> entry : errorMap.entrySet()) {
                System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
            }
        }
        if (!bindingResult.hasErrors()) {
            try {
                Guest guest = iGuestService.findGuestById(likeCommentDto.getGuestId());
                Comment comment = iCommentService.findCommentById(likeCommentDto.getCommentId());
                if (guest == null || comment == null) {
                    return new ResponseEntity<>(new ResponseObject<>(false, "FAILED TO FIND GUEST OR COMMENT", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
                } else {
                    LikeComment likeComment = iLikeCommentService.findLikeCommentByGuestIdAndCommentId(likeCommentDto.getGuestId(), likeCommentDto.getCommentId());
                    if (likeComment == null) {
                        LikeComment likeComment1= new LikeComment();
                        likeComment1.setGuest(guest);
                        likeComment1.setComment(comment);
                        likeComment1.setLikeCommentFlag(true);
                        iLikeCommentService.createLikeComment(likeComment1);
                        return new ResponseEntity<>(new ResponseObject<>(true, "Tạo mới like thành công!", errorMap, new ArrayList<>()), HttpStatus.OK);
                    } else {
                        likeComment.setLikeCommentFlag(likeCommentDto.getLikeCommentFlag());
                        iLikeCommentService.updateLikeComment(likeComment, likeComment.getId());
                        return new ResponseEntity<>(new ResponseObject<>(true, "Update like comment thành công", errorMap, new ArrayList<>()), HttpStatus.OK);
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new ResponseEntity<>(new ResponseObject<>(false, "FAILED", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
    }
}
