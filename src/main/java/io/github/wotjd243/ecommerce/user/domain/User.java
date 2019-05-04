package io.github.wotjd243.ecommerce.user.domain;

import java.util.List;

public class User {
    private final String id;
    private List<String> orderList;

    public User(String id) {
        this.id = id;
    }


}
/*
- 사용자
    - [ ]  사용자는 고유한 ID를 가지고 있다.
    - [ ]  사용자는 물품을 등록할 수 있다
    - [ ]  사용자는 자신이 등록한 물품 목록을 볼 수 있다.
    - [ ]  사용자는 등록되어 있는 물품 중 선택하여 장바구니에 추가할 수 있다.
    - [ ]  사용자는 자신의 장바구니에 들어있는 물품의 목록을 조회할 수 있다.
    - [ ]  사용자는 자신의 장바구니에 들어있는 물건을 구매할 수 있다.
    - [ ]  사용자는 자신이 구매한 물품의 목록을 조회할 수 있다.
 */
