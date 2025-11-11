package com.biu;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {
    /**
     * @Author Biu
     * ClassName test
     */

    public static void main(String[] args) {
        String projectPath = "D:/code tool/mybatis-plus/securityUserCenter";
        String parentPackage = "com.biu";
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/user_center", "root", "12345600++")
                // 全局配置
                .globalConfig((scanner, builder) ->
                                builder
//                            .author(scanner.apply("请输入作者：")) //固定作者只需.author("Biu)
                                        .author("Biu").outputDir(projectPath)
                                        .enableSwagger() // 开启 swagger 模式

//                            .fileOverride()
                        // 覆盖已生成文件
                )
                // 包配置
                .packageConfig((scanner, builder) -> builder
//                            .parent(scanner.apply("请输入包名：com.biu.initdemo"))
                                .parent(parentPackage)  // 直接设置包名，固定包名而不是通过 scanner 提示用户输入
                                .entity("model.entity")

                )

                .injectionConfig(consumer -> {
                    List<CustomFile> customFiles = new ArrayList<>();
                    customFiles.add(new CustomFile.Builder()
                            .fileName("VO.java")                          // 输出的文件名后缀
                            .templatePath("/templates/model/vo/VO.ftl")       // 模板路径
                            .packageName("model.vo")                            // 包名
                            .enableFileOverride()                          // 覆盖已存在的
                            .build());
                    consumer.customFile(customFiles);
                })
                .injectionConfig(consumer -> {
                    List<CustomFile> customFiles = new ArrayList<>();
                    customFiles.add(new CustomFile.Builder()
                            .fileName("DTO.java")                          // 输出的文件名后缀
                            .templatePath("/templates/model/dto/DTO.ftl")       // 模板路径
                            .packageName("model.dto")                            // 包名
                            .enableFileOverride()                          // 覆盖已存在的
                            .build());
                    consumer.customFile(customFiles);
                })

                // 策略配置
                .strategyConfig((scanner, builder) -> builder
                        .addInclude(getTables("all"))  // 这个直接固定生成所有的表
//                    .addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))     //指定表生成
                        .entityBuilder().enableFileOverride()    //符合entity格式
                        .enableLombok() //开启lombok
                        .enableTableFieldAnnotation() // 开启 swagger 注解（如 @ApiModel @ApiModelProperty）
                        .naming(NamingStrategy.underline_to_camel)           // 表名映射策略，下划线转驼峰
                        .columnNaming(NamingStrategy.underline_to_camel)     // 字段名映射策略，下划线转驼峰
                        /**
                         * 数据库对创建时间，更新时间做了自动填充，不需要在mybatis-plus设置
                         *     createTime      DATETIME DEFAULT CURRENT_TIMESTAMP not NULL COMMENT '创建时间',
                         *     updateTime      DATETIME DEFAULT CURRENT_TIMESTAMP not null  ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         *
                         */

                        .controllerBuilder().enableFileOverride()
                        .mapperBuilder().enableFileOverride()
                        .serviceBuilder().enableFileOverride()
                        .build())

                .templateEngine(new FreemarkerTemplateEngine())
                .execute();


    }


    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }


}
