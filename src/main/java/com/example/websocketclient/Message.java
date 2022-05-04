package com.example.websocketclient;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private String msgId;
    private String msgDt;
}
