package com.rebelapp.pcm.config;

public class Settings {
	
	/**
	 *  設定
	 */
	
	
	
	/* 定数管理 */
	public enum CONTACT_TOOLS{
		/**
		 * 連絡ツール
		 *   GoogleHangout
		 *   Zoom
		 *   Slack
		 *   その他
		 */
		
		GOOGLEHANGOUT("Google Hangout"),
		ZOOM("Zoom"),
		SLACK("Slack"),
		OTHER("その他");
		
		private final String value;
		
		private CONTACT_TOOLS(final String value) {
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}		
	}
	
	public enum CONNTACT_DATE{
		/**
		 * 連絡可能時間
		 *   いつでも
		 *   平日
		 *   平日午前
		 *   平日午後
		 *   平日夜
		 *   休日
		 *   休日午前
		 *   休日午後
		 *   休日夜
		 *   不定期
		 */
		
		ALWAYS("いつでも"),
		ONDAY("平日"),
		ONDAY_MORNING("平日午前"),
		ONDAY_AFTERNOON("平日午後"),
		ONDAY_NIGHT("平日夜"),
		OFFDAY("休日"),
		OFFDAY_MORNING("休日午前"),
		OFFDAY_AFTERNOON("休日午後"),
		OFFDAY_NIGHT("休日夜"),
		IRREGULAR("不定期");
		
		private final String value;
		
		private CONNTACT_DATE(final String value) {
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}		
	}

	public enum STATUS{
		/**
		 * 応募ステータス
		 *   0: 応募中
		 *   1: 承認
		 *   2: 終了
		 *   3: 削除
		 */
		
		APPLYING(0),
		PERMITED(1),
		FINISHED(2),
		DELETE(9);
		
		private final int value;
		
		private STATUS(final int value) {
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}		
	}
	
}
