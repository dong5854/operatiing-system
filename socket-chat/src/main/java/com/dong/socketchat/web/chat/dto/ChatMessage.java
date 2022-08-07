package com.dong.socketchat.web.chat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    // 메시지 타입 : 입장, 대화
    public enum MessageType {
        ENTER, TALK
    }
    private MessageType type; // 메시지 타입
    private String roomId; // 대화방 아이디(번호)
    private String sender; // 메시지 발신자
    private String message; // 메시지
}
