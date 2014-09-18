package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Cludept")]
	public class Cludept
	{
		private var _id : Number;
		
		private var _clusterid : Clustertbl;
		private var _deptid : Dept;

		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get clusterid():Clustertbl
		{
			return _clusterid;
		}

		public function set clusterid(value:Clustertbl):void
		{
			_clusterid = value;
		}

		public function get deptid():Dept
		{
			return _deptid;
		}

		public function set deptid(value:Dept):void
		{
			_deptid = value;
		}


	}
}