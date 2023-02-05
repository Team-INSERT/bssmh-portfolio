package com.bssmh.portfolio.web.domain.comment.controller;

import com.bssmh.portfolio.web.config.security.context.MemberContext;
import com.bssmh.portfolio.web.domain.comment.controller.rq.DeleteCommentRq;
import com.bssmh.portfolio.web.domain.comment.controller.rq.SaveCommentRq;
import com.bssmh.portfolio.web.domain.comment.controller.rq.UpdateCommentRq;
import com.bssmh.portfolio.web.domain.comment.controller.rs.FindCommentRs;
import com.bssmh.portfolio.web.domain.comment.service.CommentService;
import com.bssmh.portfolio.web.domain.comment.service.FindCommentService;
import com.bssmh.portfolio.web.endpoint.ListResponse;
import com.bssmh.portfolio.web.path.ApiPath;
import com.bssmh.portfolio.web.utils.RoleCheckUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "댓글")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final FindCommentService findCommentService;

    @Operation(summary = "댓글 리스트 조회")
    @GetMapping(ApiPath.COMMENT_PORTFOLIO_ID)
    public ListResponse<FindCommentRs> findComment(@PathVariable("portfolio-id") Long portfolioId) {
        return findCommentService.findCommentByPortfolioId(portfolioId);
    }

    @Operation(summary = "댓글 생성")
    @PostMapping(ApiPath.COMMENT)
    public void saveComment(@AuthenticationPrincipal MemberContext memberContext,
                            @Validated @RequestBody SaveCommentRq rq) {
        RoleCheckUtil.moreThanMember(memberContext.getRole());
        commentService.saveComment(memberContext, rq);
    }

    @Operation(summary = "댓글 수정")
    @GetMapping(ApiPath.COMMENT)
    public void updateComment(@AuthenticationPrincipal MemberContext memberContext,
                              @Validated @RequestBody UpdateCommentRq rq) {
        RoleCheckUtil.moreThanMember(memberContext.getRole());

    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping(ApiPath.COMMENT)
    public void deleteComment(@AuthenticationPrincipal MemberContext memberContext,
                              @Validated @RequestBody DeleteCommentRq rq) {
        RoleCheckUtil.moreThanMember(memberContext.getRole());

    }

}
