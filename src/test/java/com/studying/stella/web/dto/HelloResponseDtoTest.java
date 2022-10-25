package com.studying.stella.web.dto;
import static org.assertj.core.api.Assertions.*;

public class HelloResponseDtoTest {

    public void 롬복_기능_테스트(){

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        //(???) 이부분 import 시도했으나 안됨. 인터넷에서 직접 임포트문 가져와도 안되네...
        //asserThat(dto.getName()).isEqualTo(name);
        //asserThat(dto.getAmount()).isEqualTo(amount);
    }

}
