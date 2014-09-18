package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Municipal")]
	public class Municipal
	{
		private var _id : Number;
		private var _name : String;
		private var _provinceid : Province;

		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get name():String
		{
			return _name;
		}

		public function set name(value:String):void
		{
			_name = value;
		}

		public function get provinceid():Province
		{
			return _provinceid;
		}

		public function set provinceid(value:Province):void
		{
			_provinceid = value;
		}

	}
}