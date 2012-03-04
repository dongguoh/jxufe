	<!--  播放 图片 -->
	
	<div class="rightContainerContent"> 
		
		<img align="left"   src="../../photos/9.jpg"   alt="江西财经大学" width="400" height="200" id="photo">
		
		 <div id="demo" style="overflow:hidden;height:200px;width:190px; overflow:hidden;">
				<div id=demo1> 
					<a href="#1" ><img border="0"  src="../../photos/small1.jpg" width="190" height="60"></a>
					<a href="#2" ><img border="0"  src="../../photos/small2.jpg" width="190" height="60" ></a>
					<a href="#3" ><img border="0"  src="../../photos/small3.jpg" width="190" height="60"></a>
					<a href="#4" ><img border="0"  src="../../photos/small4.jpg" width="190" height="60"></a>
				</div>
				<div id=demo2>
				</div>
		</div>		
		 
   </div>
   
<script type="text/javascript">
var speed=40
var demo=document.getElementById("demo");
var demo2=document.getElementById("demo2");
var demo1=document.getElementById("demo1");
demo2.innerHTML=demo1.innerHTML
function Marquee(){
	if(demo2.offsetTop-demo.scrollTop<=0)
		demo.scrollTop-=demo1.offsetHeight
	else{
		demo.scrollTop++
	}
}
var MyMar=setInterval(Marquee,speed)
demo.onmouseover=function() {clearInterval(MyMar)}
demo.onmouseout=function() {MyMar=setInterval(Marquee,speed)}
</script>
	