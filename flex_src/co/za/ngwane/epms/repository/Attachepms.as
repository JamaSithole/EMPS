package co.za.ngwane.epms.repository
{
	import flash.utils.ByteArray;

	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Attachepms")]
	public class Attachepms
	{
		
		private var _id : Number;
		private var _ref : String;
		private var _attachment :  ByteArray;
		private var _qoupdid : Qoupd;
		private var _name : String;
		private var _sizefile : String;

		public function get attachment():ByteArray
		{
			return _attachment;
		}

		public function set attachment(value:ByteArray):void
		{
			_attachment = value;
		}

		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get ref():String
		{
			return _ref;
		}

		public function set ref(value:String):void
		{
			_ref = value;
		}

		public function get qoupdid():Qoupd
		{
			return _qoupdid;
		}

		public function set qoupdid(value:Qoupd):void
		{
			_qoupdid = value;
		}

		public function get name():String
		{
			return _name;
		}

		public function set name(value:String):void
		{
			_name = value;
		}

		public function get sizefile():String
		{
			return _sizefile;
		}

		public function set sizefile(value:String):void
		{
			_sizefile = value;
		}


	}
}