var timer = 3;

var photos = [
    ['1', '江西财经大学'],
    ['2','江西财经大学'],
    ['3', '江西财经大学'],
    ['4', '江西财经大学'],
    ['5', '江西财经大学'],
    ['6', '江西财经大学'],
	['7', '江西财经大学'],
    ['8', '江西财经大学'],  
	['9', '江西财经大学']
];

var img, count = 1;

function startSlideshow()
{
  img = document.getElementById('photo');
  window.setTimeout('cueNextSlide()', timer * 1000);
}

function cueNextSlide()
{
  var next = new Image;

  next.onerror = function()
  {
    alert('加载下一张图片失败!!');
  };

  next.onload = function()
  {
    img.src = next.src;
    img.alt = photos[count][1];


    if (++count == photos.length) { count = 0; }

    window.setTimeout('cueNextSlide()', timer * 1000);
  };

  next.src = '../../photos/' + photos[count][0] + '.jpg';

}

addLoadListener(startSlideshow);

function addLoadListener(fn)
{
  if (typeof window.addEventListener != 'undefined')
  {
    window.addEventListener('load', fn, false);
  }
  else if (typeof document.addEventListener != 'undefined')
  {
    document.addEventListener('load', fn, false);
  }
  else if (typeof window.attachEvent != 'undefined')
  {
    window.attachEvent('onload', fn);
  }
  else
  {
    var oldfn = window.onload;
    if (typeof window.onload != 'function')
    {
      window.onload = fn;
    }
    else
    {
      window.onload = function()
      {
        oldfn();
        fn();
      };
    }
  }
}
