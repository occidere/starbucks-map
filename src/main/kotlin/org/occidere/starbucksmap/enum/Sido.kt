package org.occidere.starbucksmap.enum

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-11
 */
enum class Sido(val korName: String, val code: String) {
    SEOUL("서울", "01"),
    GYEONGGI("경기", "08"),
    GWANGJU("광주", "02"),
    DAEGU("대구", "03"),
    DAEJEON("대전", "04"),
    BUSAN("부산", "05"),
    ULSAN("울산", "06"),
    INCHEON("인천", "07"),
    GANGWON("강원", "09"),
    GYEONGNAM("경남", "10"),
    GYEONGBUK("경북", "11"),
    JEONNAM("전남", "12"),
    JEONBUK("전북", "13"),
    CHUNGNAM("충남", "14"),
    CHUNGBUK("충북", "15"),
    JEJU("제주", "16"),
    SEJONG("세종", "17")
    ;

    override fun toString() = "Sido($name, $korName, $code)"
}