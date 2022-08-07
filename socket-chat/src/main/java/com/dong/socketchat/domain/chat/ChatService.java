package com.dong.socketchat.domain.chat;

import com.dong.socketchat.web.chat.dto.ChatRoom;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

public interface ChatService {
        void init();
        public List<ChatRoom> findAllRoom();
        public ChatRoom findRoomById(String roomId);
        public ChatRoom createRoom(String name);
        public <T> void sendMessage(WebSocketSession session, T message);
}
