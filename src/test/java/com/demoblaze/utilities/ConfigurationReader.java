package com.demoblaze.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {
        try {
            //which file to read
            String path = "configuration.properties";
            //read to file into java, finds the file using path
            FileInputStream input = new FileInputStream(path);
            //properties --> class that store properties in key & value format
            properties = new Properties();
            //the values from the file input is loaded/ fed in to the properties object
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String get(String keyName){
        return properties.getProperty(keyName);
    }

}
/**
 * Encapsulation olayı burada vardır. Çünki private bir instance veriable bulunmaktadır.
 * Bu ConfigurationReader sınıfı, configuration.properties adlı bir dosyadan yapılandırma ayarlarını okumak için kullanılır.
 * Bu dosya, anahtar-değer çiftleri şeklinde yapılandırma ayarlarını depolar. Sınıfın amacı, yapılandırma ayarlarını
 * okumak için bir yöntem sağlamaktır. Bu yöntem, get olarak adlandırılır ve bir anahtar parametresi alır.
 * Belirtilen anahtarın değerini döndürür. Sınıfın statik bir başlatma bloğu (static blok) bulunur.
 * Bu blok, sınıfın yüklenmesi sırasında otomatik olarak çalışır. Bu blok, configuration.properties dosyasını okur ve
 * içeriğini Properties nesnesine yükler. Dosya okuma işlemi try-catch bloğu içinde gerçekleşir.
 * Dosya yolu belirtilir ve FileInputStream kullanılarak dosya okunur. Okunan veriler Properties nesnesine yüklenir ve
 * input akışı kapatılır. Eğer bir hata oluşursa, hata mesajı e.printStackTrace() ile yazdırılır.
 *
 * Sonuç olarak, get metodu keyName parametresi alır ve bu anahtara karşılık gelen değeri properties nesnesinden alarak döndürür.
 * Böylece, ConfigurationReader.get("anahtarAdi") şeklinde kullanarak yapılandırma ayarlarını elde edebilirsiniz.
 *
 * Bu sınıf, yapılandırma ayarlarını tek bir yerde tutmayı sağlar ve bu ayarları uygulama içinde kolayca erişilebilir hale getirir.
 * Bu şekilde, yapılandırma ayarlarını değiştirmek gerektiğinde sadece configuration.properties dosyasını güncellemek yeterlidir
 * ve kodda herhangi bir değişiklik yapmanız gerekmez.
 */