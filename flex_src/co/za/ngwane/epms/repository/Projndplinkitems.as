package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Projndplinkitems")]
	public class Projndplinkitems
	{
		public function Projndplinkitems()
		{
		}
		
		private var _id : Number;
		private var _projtblid : Projtbl;
		private var _ndpltemsid : Ndpltems;

		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get projtblid():Projtbl
		{
			return _projtblid;
		}

		public function set projtblid(value:Projtbl):void
		{
			_projtblid = value;
		}

		public function get ndpltemsid():Ndpltems
		{
			return _ndpltemsid;
		}

		public function set ndpltemsid(value:Ndpltems):void
		{
			_ndpltemsid = value;
		}


	}
}