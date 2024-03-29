package com.efub.community.domain.board.dto;

import com.efub.community.domain.board.domain.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {
	private Long postId;
	private Long boardId;
	private String boardName;
	private String writerName;
	private String content;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;

	public static PostResponseDto of(Post post) {
		String writerName;
		if(post.isAnonymous())
		{
			writerName = "익명";
		}
		else{
			writerName = post.getWriter().getNickname();
		}
		return PostResponseDto.builder()
				.postId(post.getPostId())
				.boardId(post.getBoard().getBoardId())
				.boardName(post.getBoard().getName())
				.writerName(writerName)
				.content(post.getContent())
				.createdDate(post.getCreatedDate())
				.modifiedDate(post.getModifiedDate())
				.build();
	}
}
