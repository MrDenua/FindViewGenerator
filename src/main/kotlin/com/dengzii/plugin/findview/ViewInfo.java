package com.dengzii.plugin.findview;

/**
 * <pre>
 * author : dengzi
 * e-mail : dengzii@foxmail.com
 * github : <a href="https://github.com/dengzii">...</a>
 * time   : 2019/9/27
 * desc   :
 * </pre>
 */
public class ViewInfo {

    private final String type;
    private final String id;
    private final String layout;
    private final String fullName;
    private String mappingField;
    private boolean generate = true;

    public ViewInfo(String type, String id, String layout, String fullName) {
        this.type = type;
        this.id = id;
        this.layout = layout;
        this.fullName = fullName;
    }

    public void genMappingField() {

        StringBuilder builder = new StringBuilder(Config.FIELD_NAME_PREFIX);
        if (id.contains("_")) {
            String[] split = id.toLowerCase().split("_");
            for (String s : split) {
                if (s.length() >= 1) {
                    String c = s.substring(0, 1).toUpperCase();
                    builder.append(c).append(s.substring(1));
                }
            }
        } else {
            String c = id.substring(0, 1).toUpperCase();
            builder.append(c).append(id.substring(1));
        }
        this.mappingField = builder.toString();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getLayout() {
        return layout;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMappingField() {
        return mappingField;
    }

    public void setMappingField(String mappingField) {
        this.mappingField = mappingField;
    }

    public boolean isGenerate() {
        return generate;
    }

    public void setGenerate(boolean generate) {
        this.generate = generate;
    }
}
