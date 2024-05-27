package org.example.lesson;

public enum LessonType {
    MAJOR ("major"),      // اختصاصی
    ELECTIVE("elective"),   // عمومی
    LAB("lab"),        // کارگاه و آزمایشگاه
    CORE("core");   // پایه
    String type ;
    private LessonType (String type) {
        this.type = type ;
    }
}
