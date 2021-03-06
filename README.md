# HW1_2_20180800
> 안드로이드 스튜디오(자바 활용) 공부 - 스마트 모바일 프로그래밍 과제 1
> 참고 : https://nonameunknown.tistory.com/m/5(버튼 색 변경 관련)
> 참고 : https://developer.android.com/guide/topics/ui/notifiers/toasts(toast 메세지 관련)

### 앱 실행 화면
<img width="404" alt="실행화면 캡쳐" src="https://user-images.githubusercontent.com/68562176/112725832-84f03f80-8f5d-11eb-867b-5d6999c529a9.png">

### 구현 기능
1. input에서 입력 받은 값을 '글자 나타내기' 버튼을 눌렀을 때 토스트 메세지로 출력하기
2. input에서 입력 받은 값을 '홈페이지 열기 버튼'을 눌렀을 때 입력한 url로 열기
3. 처음에는 기본 이미지를 띄우고 라디오 버튼 클릭시 다른 이미지로 변경하기(라디오 버튼마다 1개의 이미지, 총 2개의 이미지가 있음)

### 새롭게 알게 된 내용
1. id 값 가져오기 (findViewById 메소드 / 위젯의 변수명 = (위젯명) findViewById(R.id.가져 올 위젯의 아이디);)
2. 안드로이드 프로젝트의 구조
3. input에서 입력받은 값을 저장하여 사용하는 방법
5. url로 액티비티 실행하는 방법
6. 라디오 그룹과 라디오 버튼의 사용법
7. 버튼 색 변경(background)
8. 토스트 메시지 띄우기

-----
#### 안드로이드 프로젝트의 구조
1. AndroidManifest.xml    
앱의 여러가지 정보들을 담고 있다. 모든 activity는 이 파일에서 선언이 되어야만 사용될 수 있다. activity 파일을 만들게 되면 이곳에서 자동으로 선언이 된다.
2. activity_mail.xml    
눈에 보이는 디자인적인 요소를 다루는 파일. UI를 구현하는 파일이다. xml 파일을 이용하면 UI 레 이아웃과 그 안에 들어있는 화면 요소드를 디자인할 수 있다. xml 파일 중에서도 activity_main.xml 파일은 가장 메인이 되는 화면이며, 앱을 실행시켰을 때 가장 먼저 보인다.
3. MainActivity.java    
activity_mail.xml과 쌍을 이루어 존재하며, activity파일에서 setContentView(R.layout.activity_main);코드 를 사용하여 xml파일을 연결한다. 앱이 작동하는 방식에 대해 정의한다. 이 파일은 앱의 진입점으로 앱이 빌드되고 실행되면 이 activity파일의 인스턴스를 실행하고 레이아웃이 들어있는 xml파일을 로드 한다.
4. strings.xml    
문자열값들을 저장해놓은 파일이다. xml파일에서 @string/리소스 형식으로 값을 불러올 수 있다. xml text에서 값을 바로 써도 되지만 문자열 값을 모아두면 수정이 더 간편해져 관리하기에 편하다.
5. drawable 폴더     
res 폴더 안에 있는 패키지이다. res폴더는 resource 폴더로 ui관련 파일, 디자인 리소스, 문자열 리소 스를 담고 있다. 그 중에서 drawable 패키지는 이미지 파일들을 담고 있다. 앱에 사용될 이미지들을 이 폴더에 담아두고 xml에서 불러서 사용한다.

#### 버튼 색 변경
버튼 색상이 바뀌지 않고 커스텀버튼 또한 적용이 되지 않는 문제가 발생. 계속 보라색으로 나오고 원하는 색으로 바뀌지 않음.     
* 원인 : 앱의 테마가 Theme.MaterialComponents를 default로 사용하면서 발생됨
* 해결방법 : 앱의 테마를 Theme.AppCompat.Light로 변경
* 테마 변경 방법 : 
  1) app -> res -> values -> themes.xml에 들어감
  2) 3번째 줄에 ```<style name="Theme.Midterm12_20180800" parent="Theme.MaterialComponents.DayNight.DarkActionBar">```       이 부분에서 parent안에 내용을 Theme.AppCompat.Light로 바꿈 
* 변경 후 : ```<style name="Theme.Midterm12_20180800" parent="Theme.AppCompat.Light">```

#### 토스트 메시지 띄우기
* 방법 :
  1) makeText() 메소드를 이용하여 객체 생성
  2) show() 메소드를 이용하여 화면에 띄우기
* 코드 : 
```
Toast toast = Toast.makeText(context, text, duration);
toast.show();
```
아래와 같이 객체 생성과 동시에 보여줄 수도 있음
```
toast = Toast.makeText(context, text, duration).show();
```
* 객체 생성 파라미터 : 객체를 생성할 때는 context, text, duration 파라미터를 전달해주어야한다.
  1) context : getApplicationContext() 메소드를 이용해 context를 가져온다.
  2) text : 토스트로 띄우고 싶은 메세지 내용
  3) duration : 토스트 메세지를 얼마나 길게 보여줄 지 결정한다. 값은 ```Toast.LENGTH_LONG```또는```Toast.LENGTH_SHORT``` 중 원하는 것을 사용하면 된다.
