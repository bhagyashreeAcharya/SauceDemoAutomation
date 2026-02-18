@BeforeMethod
public void setup() {

    ChromeOptions options = new ChromeOptions();

    // Always show ChromeOptions skill: password manager handling
    Map<String, Object> prefs = new HashMap<>();
    prefs.put("credentials_enable_service", false);
    prefs.put("profile.password_manager_enabled", false);
    prefs.put("profile.password_manager_leak_detection", false);

    options.setExperimentalOption("prefs", prefs);

    // Detect CI environment (GitHub Actions automatically sets CI=true)
    if ("true".equals(System.getenv("CI"))) {
        System.out.println("Running in CI environment");

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
    } else {
        System.out.println("Running in local environment");
    }

    driver = new ChromeDriver(options);

    driver.manage().window().maximize();

    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.get("https://www.saucedemo.com/");
}
