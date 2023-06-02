import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//사용하다보면 셀레니움측에서 제공해주는 라이브러리 다쓰니깐 유틸 및 드라이브 소스 등등 전부 import 권장
public class NaverSelenium {
 
	private WebDriver driver;
	private WebElement element;
	private String url;
	
 	// 1. 드라이버 설치 경로
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:/Users/miso/Desktop/chromedriver_win32/chromedriver.exe";
	
	public NaverSelenium(){
		// WebDriver 경로 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
				
		// 2. WebDriver 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");//크롬 브라우저를 실행할 때 창 크기를 최대화
		options.addArguments("--disable-popup-blocking");//팝업 창 차단 기능을 비활성화
        
		driver = new ChromeDriver(options);
		
		url = "https://www.naver.com/";
	}
	
	public void activateBot() {
		try {
			driver.get(url);
			Thread.sleep(2000); // 3. 페이지 로딩 대기 시간
			
			//네이버의 로그인 태그를 찾아서 데이터를 입력해 진행한다.
			// 4. 로그인 버튼 클릭
			element = driver.findElement(By.className("link_login"));
			element.click();
			
			Thread.sleep(1000);
			
			// ID 입력
			element = driver.findElement(By.id("id"));
			element.sendKeys("아이디입니다");
			
			// 비밀번호 입력
			element = driver.findElement(By.id("pw"));
			element.sendKeys("비밀번호입니다");
			
			// 전송
			element = driver.findElement(By.className("btn_global"));
			element.submit();//로그인 버튼 클릭
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close(); // 5. 브라우저 종료
		}
	}
	
	public static void main(String[] args) {
		NaverSelenium bot1 = new NaverSelenium();
		bot1.activateBot();
	}
}