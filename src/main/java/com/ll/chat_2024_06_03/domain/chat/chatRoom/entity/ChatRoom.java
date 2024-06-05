package com.ll.chat_2024_06_03.domain.chat.chatRoom.entity;

import com.ll.chat_2024_06_03.global.jpa.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder // 상속 받기 위함
@Getter
@Setter
@ToString(callSuper = true)
public class ChatRoom extends BaseEntity {


    private String name;

    public ChatRoom(String name){
        this.name = name;
    }


    @Builder.Default
    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ChatMessage> chatMessages = new ArrayList<>();

    public void writeMessage(String writerName, String content) {
        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(this)
                .writerName(writerName)
                .content(content)
                .build();

        chatMessages.add(chatMessage);
    }
}
