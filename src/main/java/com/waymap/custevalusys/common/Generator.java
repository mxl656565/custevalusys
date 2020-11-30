package com.waymap.custevalusys.common;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：使用Java方式运行MBG
 *
 *
 */
public class Generator {
    public static void main(String[] args) throws URISyntaxException {
        try {
            //MBG 执行过程中的警告信息
            List<String> warnings = new ArrayList<String>();
            //当生成的代码重复时，覆盖原代码
            boolean overwrite = true;

            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            //读取我们的 MBG 配置文件
            InputStream is = classloader.getResourceAsStream("generator/generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(is);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            //创建 MBG
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            //执行生成代码
            myBatisGenerator.generate(null);
            //输出警告信息
            for (String warning : warnings) {
                System.out.println(warning);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
    }
}