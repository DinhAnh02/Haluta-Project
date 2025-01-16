package Haluta.example.demo.Response;

import lombok.Getter;

@Getter
public class ResponseMessage {
        private final String message;
        public ResponseMessage(String message) {
            this.message = message;
        }

}


