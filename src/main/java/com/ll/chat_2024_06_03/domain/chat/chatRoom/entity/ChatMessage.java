package com.ll.chat_2024_06_03.domain.chat.chatRoom.entity;

import com.ll.chat_2024_06_03.global.jpa.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder // 상속 받기 위함
@Getter
@Setter
@ToString(callSuper = true)
public class ChatMessage extends BaseEntity {


    @ManyToOne
    private ChatRoom chatRoom;

    @Getter
    private String writerName;

    @Getter
    private String content;

}
