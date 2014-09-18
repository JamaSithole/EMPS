package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Province")]
	public class Province
	{
		private var _id : Number;
		private var _name : String;

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

	}
}