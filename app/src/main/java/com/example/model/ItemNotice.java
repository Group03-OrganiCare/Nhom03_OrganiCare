package com.example.model;

public class ItemNotice {
    private int NoticeThumb;
    private String NoticeNumber;
    private String NoticeContent;
    private String NoticeTime;

    public ItemNotice(int noticeThumb, String noticeNumber, String noticeContent, String noticeTime) {
        NoticeThumb = noticeThumb;
        NoticeNumber = noticeNumber;
        NoticeContent = noticeContent;
        NoticeTime = noticeTime;
    }

    public int getNoticeThumb() {
        return NoticeThumb;
    }

    public void setNoticeThumb(int noticeThumb) {
        NoticeThumb = noticeThumb;
    }

    public String getNoticeNumber() {
        return NoticeNumber;
    }

    public void setNoticeNumber(String noticeNumber) {
        NoticeNumber = noticeNumber;
    }

    public String getNoticeContent() {
        return NoticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        NoticeContent = noticeContent;
    }

    public String getNoticeTime() {
        return NoticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        NoticeTime = noticeTime;
    }
}
