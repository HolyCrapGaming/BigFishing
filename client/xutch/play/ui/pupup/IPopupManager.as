/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.play.ui.pupup {
	import flash.display.DisplayObject;
	import flash.display.Sprite;

	/**
	 * @author XuTiancheng
	 * 下午05:12:24
	 */
	public interface IPopupManager {
		/**
		 * @param sp 传入顶层
		 */
		function init(sp : Sprite) : void;
		function addPopup(win : DisplayObject) : void;
		function addPopupInQueue(win : DisplayObject, priority : int = 1) : void;
		function removePopup(win : DisplayObject) : void;
	}
}