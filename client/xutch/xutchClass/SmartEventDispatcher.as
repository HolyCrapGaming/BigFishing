/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.xutchClass {
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;

	/**
	 * @author XuTiancheng
	 * 2011-4-14
	 * 预防了监听者的重复添加和移除
	 *
	 * removeAllListeners() 移除当前添加的所有监听者
	 *
	 * removeAllEvents() 移除当前所有持久化的event
	 *
	 * dispatchEventSmart(type:String) 传入type自动创建Event (性能提升约37% 但会持久化这个type的event)
	 *
	 * dispose() 干掉所有监听和所有事件 (会破坏结构)
	 */
	public class SmartEventDispatcher extends EventDispatcher {
		private var _vct_listeners : Vector.<Object> = new Vector.<Object>();
		private var _obj_evts : Object = {};

		public function SmartEventDispatcher(target : IEventDispatcher = null) {
			super(target);
		}

		override public function addEventListener(type : String, listener : Function, useCapture : Boolean = false, priority : int = 0, useWeakReference : Boolean = false) : void {
			for (var i : int = 0, lenI : int = _vct_listeners.length; i < lenI; i++) {
				var obj : Object = _vct_listeners[i];
				if (obj.type == type && obj.func == listener && obj.useCapture == useCapture)
					return;
			}
			_vct_listeners.push({type: type, func: listener, useCapture: useCapture});
			super.addEventListener(type, listener, useCapture, priority, useWeakReference);
		}

		/**
		 * 会自动创建type类型的Event 并做储存
		 */
		public function dispatchEventSmart(type : String) : Boolean {
			if (!_obj_evts.hasOwnProperty(type))
				_obj_evts[type] = new Event(type);
			return super.dispatchEvent(_obj_evts[type]);
		}

		override public function removeEventListener(type : String, listener : Function, useCapture : Boolean = false) : void {
			for (var i : int = 0, lenI : int = _vct_listeners.length; i < lenI; i++) {
				var obj : Object = _vct_listeners[i];
				if (obj.type == type && obj.func == listener && obj.userCapture == useCapture) {
					_vct_listeners.splice(i, 1);
					super.removeEventListener(type, listener, useCapture);
				}
			}
		}

		public function dispose() : void {
			//干掉所有监听
			removeAllListeners();
			_vct_listeners = null;
			//干掉储存的所有evt
			removeAllEvents();
			_obj_evts = null;
		}

		public function removeAllEvents() : void {
			for (var i : String in _obj_evts)
				delete _obj_evts[i]
		}

		public function removeAllListeners() : void {
			for (var i : int = 0, lenI : int = _vct_listeners.length; i < lenI; i++) {
				var obj : Object = _vct_listeners[i];
				super.removeEventListener(obj.type, obj.listener, obj.useCapture);
			}
			_vct_listeners.length = 0;
		}
	}
}