package pet.hospital.backend.intermediator.helper;

import lombok.Getter;

@Getter
public enum VideoType {
    MP4("mp4", "aac", "h264"),
    WEBM("webm", "libvorbis", "libvpx-vp9");

    private String format; // 视频格式
    private String audioEncode; // 音频编码
    private String videoEncode; // 视频编码

    private VideoType(String format, String audioEncode, String videoEncode) {
        this.format = format;
        this.audioEncode = audioEncode;
        this.videoEncode = videoEncode;
    }
}
