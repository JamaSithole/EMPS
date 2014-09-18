package co.za.ngwane.epms.repository
{
	import mx.collections.ArrayCollection;

	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Sysmod")]
	public class Sysmod
	{
		public function Sysmod()
		{
		}
		
		private var _id : Number;
		private var _code : String;
		private var _description : String;
		private var _status : String;
		private var _usermodCollection : ArrayCollection;
		private var _name : String;
		private var _isAdded : Boolean;

		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get code():String
		{
			return _code;
		}

		public function set code(value:String):void
		{
			_code = value;
		}

		public function get description():String
		{
			return _description;
		}

		public function set description(value:String):void
		{
			_description = value;
		}

		public function get status():String
		{
			return _status;
		}

		public function set status(value:String):void
		{
			_status = value;
		}

		public function get usermodCollection():ArrayCollection
		{
			return _usermodCollection;
		}

		public function set usermodCollection(value:ArrayCollection):void
		{
			_usermodCollection = value;
		}

		public function get name():String
		{
			return _name;
		}

		public function set name(value:String):void
		{
			_name = value;
		}

		public function get isAdded():Boolean
		{
			return _isAdded;
		}

		public function set isAdded(value:Boolean):void
		{
			_isAdded = value;
		}


	}
}