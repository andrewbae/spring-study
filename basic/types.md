# 자료형 (Types)
자바는 기본적으로 모든 문자를 유니코드로 처리한다.

## 기본 타입 (Primitive Types)
|자료형|키워드|크기|기본값|표현범위|
|---|---|---|---|---|
|논리형|`boolean`|1-bit|false|true, false|
|문자형|`char`|16-bit|\u0000|0 ~ 65,535 (\u0000 ~ \uffff)|
|정수형|`byte`|8-bit|0|-2<sup>7</sup> ~ 2<sup>7</sup>-1|
|정수형|`short`|16-bit|0|-2<sup>15</sup> ~ 2<sup>15</sup>-1|
|정수형|`int`|32-bit|0|-2<sup>31</sup> ~ 2<sup>31</sup>-1|
|정수형|`long`|64-bit|0L|-2<sup>63</sup> ~ 2<sup>63</sup>-1|
|실수형|`float`|32-bit|0.0f|-1.4E-45 ~ 3.4E38|
|실수형|`double`|64-bit|0.0d|-4.9E-324 ~ 1.7E308|

## 부동소수점 (Floating Point)
- 부동소수점은 정보통신 표준용어에 따른 표기이며 순화용어로는 떠돌이 소수점이다.
- 유효숫자를 나타내는 가수와 소수점을 나타내는 지수로 나누어 표현한다.
- 이진법에서는 십진수의 소수점이 정확하게 표현되지 않기 때문에 근사값으로 표현된다.

|자료형|전체 bits|부호 bits|지수 bits|가수 bits|가수의 표현범위 (10진수)|
|---|---|---|---|---|---|
|`float`|32-bit|1-bit|8-bit|23-bit|2<sup>23</sup>|
|`double`|64-bit|1-bit|11-bit|52-bit|2<sup>52</sup>|