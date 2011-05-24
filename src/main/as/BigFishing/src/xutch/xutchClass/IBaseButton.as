package xutch.xutchClass {
	import com.matrixjoy.game.component.SmartEventDispatcher;

	import flash.display.DisplayObject;
	import flash.text.TextField;

	/**
	 * @author XuTiancheng
	 */
	public interface IBaseButton {
		/**
		 * 释放
		 */
		function dispose() : void;
		/**
		 * 文本的竖直偏移
		 */
		function set handV(v : int) : void;
		/**
		 * 文本的横向偏移
		 */
		function set handH(h : int) : void;
		/**
		 * 获取按钮this
		 */
		function get button() : DisplayObject;
		/**
		 * 事件发送者
		 */
		function get dispatcher() : SmartEventDispatcher;
		/**
		 * 获取当前按钮的可用性
		 */
		function get enable() : Boolean;
		/**
		 * 获取tf 用于设置文本内容
		 */
		function get tf() : TextField;
		/**
		 * 通过tf 处理按钮的样式
		 */
		function processViaTF(isScaleBg : Boolean = true, isMoveTF : Boolean = true, isScaleHitArea : Boolean = true) : void;
		/**
		 * 获取按钮中的任意元素
		 */
		function getElement(name : String) : *;
		/**
		 * 设置当前按钮的可用性
		 */
		function set enable(b : Boolean) : void;
		/**
		 * 设置最小按钮宽度
		 */
		function set minWidth(w : int) : void;
		/**
		 * 改变当前状态
		 */
		function set state(state : String) : void;
		/**
		 * 纵向预留
		 */
		function set vpadding(num : int) : void;
		/**
		 * 横向预留
		 */
		function set hpadding(num : int) : void;
	}
}
