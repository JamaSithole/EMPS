package co.za.ngwane.epms.repository
{
	import mx.collections.ArrayCollection;

	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Ndp")]
	public class Ndp
	{
		private var _id : Number;
		private var _name : String;
		private var _description : String;
		
		private var _ndpltemsCollection : ArrayCollection ;

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

		public function get description():String
		{
			return _description;
		}

		public function set description(value:String):void
		{
			_description = value;
		}

		public function get ndpltemsCollection():ArrayCollection
		{
			return _ndpltemsCollection;
		}

		public function set ndpltemsCollection(value:ArrayCollection):void
		{
			_ndpltemsCollection = value;
		}


	}
}