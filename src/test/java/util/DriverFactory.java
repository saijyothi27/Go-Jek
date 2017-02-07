package util;

/**
 * Created by saijyoth on 2/7/2017.
 */
public class DriverFactory {

    protected static WebDriver driver;


    public DriverFactory() {
        initialize();
    }

    public void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }

    private void createNewDriverInstance() {

        //for firefox browser
        //System.out.println("creating driver...");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setProxyAutoconfigUrl("http://browserconfig.target.com/proxy-global.pac");

        File pathToBinary = new File("C:\\\\Program Files (x86)\\\\Mozilla Firefox\\firefox.exe");
        //File pathToBinary = new File("C:\\Users\\A042903\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        //FirefoxBinary binary = new FirefoxBinary();
        FirefoxBinary binary = new FirefoxBinary(pathToBinary);
        FirefoxProfile profile = new FirefoxProfile();
        capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        profile.setPreference("network.ntlm.send-lm-response", true);
        profile.setPreference("network.automatic-ntlm-auth.trusted-uris", "dtex4kvbppovt.cloudfront.net,tiles-cloudfront.cdn.mozilla.net,target.com,sharepoint,nexus.ensighten.com,invitemedia.com,facebook.com,targetpsp.px.247inc.net,36fb6319.mpstat.us,targetpsp.px.247-inc.net,cm.g.doubleclick.net,pixel.mathtag.com,hcdns.brsrvr.com,tgtprod-interactedge.infosysapps.com,u.optorb.com,targetpsp.px.247inc.net,evjs.optorb.com,google.com,googleads.g.doubleclick.net,cdns.brsrvr.com,login.dotomi.com,d1af033869koo7.cloudfront.net,a248.e.akamai.net,google.co.in,51af72.r.axf8.net,ajax.googleapis.com,ssl.google-analytics.com,geo.mozilla.org,ecn.dev.virtualearth.net,platform.twitter.com,twitter.com,addons.seleniumhq.org,addons.mozilla.org,ajax.googleapis.com,ecn.dev.virtualearth.net,js-agent.newrelic.com,dsply.com,addons.cdn.mozilla.net,versioncheck-bg.addons.mozilla.org,integration.richrelevance.com,securepubads.g.doubleclick.net,googletagservices.com,analytics.bluekai.com,ad.doubleclick.net,pixel.adsafeprotected.com,cdn-images.mailchimp.com,static.doubleclick.net,www.dsply.com,ssl.gstatic.com,www.gstatic.com,www.nexus-test.ensighten.com,connect.facebook.net,api.bazaarvoice.com, seclogin.target.com, *36fb6d*.mpstat.us,tiles.services.mozilla.com,usage.trackjs.com,aus4.mozilla.org,hlserve.com,51af72.m.axf8.net,c.go-mpulse.net,target.ca.assist.247-inc.net,t.acxiom-online.com,partner.googleadservices.com,tpc.googlesyndication.com,fbstatic-a.akamaihd.net,pr.ybp.yahoo.com,dg7jf5sx2cq0y.cloudfront.net");
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        driver = ThreadGuard.protect(new FirefoxDriver(binary, profile, capabilities));

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver() {
        //System.out.println("destorying driver...");
        driver.quit();
        driver = null;
    }
}
