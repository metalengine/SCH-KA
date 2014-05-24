<?php
$url="http://localhost/";
$hostname="localhost";
$username="root"; //write your username
$password="bajaksaja"; //write your password
$dbname="schka"; //write your db name
$con=mysql_connect($hostname,$username,$password);
	
mysql_select_db($dbname) or die('Could not select database');

$homepage = file_get_contents($url.'?ret=11');
//echo $homepage;

$json = str_replace("[{","",$homepage);

$homepage = str_replace("}]","",$json);

//echo $homepage."<br />";

$list = explode("},{",$homepage);
$i=0;
$j=count($list);
for($i==0;$i<$j;$i++){
	
	$str = str_replace("\"","",$list[$i]);
	//echo $str."<br />";
	list($nnip,$ndos) = explode(",",$str);
	$nip[$i] = str_replace("NIP:","",$nnip);
	$dos[$i] = str_replace("namaDosen:","",$ndos);
	//echo $nip[$i]." - ".$dos[$i]."<br />";
}
mysql_query("truncate table dosen");
for($i=0;$i<$j;$i++){
	mysql_query("insert into dosen(inisial,nama) values ('".$nip[$i]."','".$dos[$i]."')");
}
$homepage = file_get_contents($url.'?ret=14');
//echo $homepage;

$json = str_replace("[{","",$homepage);

$homepage = str_replace("}]","",$json);

//echo $homepage."<br />";

$list = explode("},{",$homepage);
$i=0;
$j=count($list);
for($i==0;$i<$j;$i++){
	
	$str = str_replace("\"","",$list[$i]);
	//echo $str."<br />";
	list($nnim,$nmhs) = explode(",",$str);
	$nim[$i] = str_replace("NIM:","",$nnim);
	$mhs[$i] = str_replace("namaMhs:","",$nmhs);
	//echo $nim[$i]." - ".$mhs[$i]."<br />";
}
mysql_query("truncate table mahasiswa");
for($i=0;$i<$j;$i++){
	mysql_query("insert into mahasiswa(nim,nama) values ('".$nim[$i]."','".$mhs[$i]."')");
}
$homepage = file_get_contents($url.'?ret=23');
//echo $homepage;

$json = str_replace("[{","",$homepage);

$homepage = str_replace("}]","",$json);

//echo $homepage."<br />";

$list = explode("},{",$homepage);
$i=0;
$j=count($list);
for($i==0;$i<$j;$i++){
	
	$str = str_replace("\"","",$list[$i]);
	//echo $str."<br />";
	list($nruang,$junk) = explode(",",$str);
	$ruang[$i] = str_replace("Ruangan:","",$nruang);
	//echo $ruang[$i]."<br />";
}
mysql_query("truncate table ruang");
for($i=0;$i<$j;$i++){
	mysql_query("insert into ruang(nama) values ('".$ruang[$i]."')");
}
$homepage = file_get_contents($url.'?ret=26');
//echo $homepage;

$json = str_replace("[{","",$homepage);

$homepage = str_replace("}]","",$json);

//echo $homepage."<br />";

$list = explode("},{",$homepage);
$i=0;
$j=count($list);
for($i==0;$i<$j;$i++){
	
	$str = str_replace("\"","",$list[$i]);
	//echo $str."<br />";
	list($nid, $njudul,$nmhs,$np1,$np2,$junk,$junk,$junk) = explode(",",$str);
	$id[$i] = str_replace("idKarya:","",$nid);
	$judul[$i] = str_replace("judulKarya:","",$njudul);
	$mhs[$i] = str_replace("namaMhs:","",$nmhs);
	$p1[$i] = str_replace("pembimbing1:","",$np1);
	$p2[$i] = str_replace("pembimbing2:","",$np2);
	//echo $id[$i]."=".$judul[$i]."<br />".$mhs[$i]." - ".$p1[$i]."/".$p2[$i]."<br />";
}
mysql_query("truncate table ka");
for($i=0;$i<$j;$i++){
	mysql_query("insert into ka(id,nim,pembimbing1,pembimbing2,judul) values (".$id[$i].",'".$nim[$i]."','".$p1[$i]."','".$p2[$i]."','".$judul[$i]."')");
}
?>

