package by.bsu.hr.command;

import java.util.Locale;
import java.util.ResourceBundle;
public class ResourseBundle{
    private static final String BUNDLE_CONSTANT="resources.text";
    public enum  ResourceBundleEnum {
        EN(ResourceBundle.getBundle(BUNDLE_CONSTANT,new Locale("en","EN"))),
        RU(ResourceBundle.getBundle(BUNDLE_CONSTANT,new Locale("ru","RU"))),
        BE(ResourceBundle.getBundle(BUNDLE_CONSTANT,new Locale("be","BY")));

        private ResourceBundle bundle;

        ResourceBundleEnum(ResourceBundle bundle) {
            this.bundle=bundle;
        }
        public String getMessage(String key){
            return bundle.getString(key);
        }
    }
}