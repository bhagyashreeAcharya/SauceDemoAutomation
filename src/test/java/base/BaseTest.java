@BeforeMethod
public void setup() {

    ChromeOptions options = new ChromeOptions();

    // Detect if running in CI (GitHub Actions sets CI=true automatically)
    String isCI = System.getenv("CI");

    if (isCI != null && isCI.equals("true")) {
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
    }

    // Your ChromeOptions skill (password manager handling)
    Map<String, Object> prefs = new HashMap<>();
    prefs.put("credentials_enable_service", false);
    prefs.put("profile.password_manager_enabled", false);
    prefs.put("profile.password_manager_leak_detection", false);

    options.setExperimentalOption("prefs", prefs);

    driver = new ChromeDriver(options);

    driver.manage().window().maximize();

    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.get("https://www.saucedemo.com/");
}
