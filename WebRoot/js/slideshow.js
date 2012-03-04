var timer = 3;

var photos = [
    ['1', '�����ƾ���ѧ'],
    ['2','�����ƾ���ѧ'],
    ['3', '�����ƾ���ѧ'],
    ['4', '�����ƾ���ѧ'],
    ['5', '�����ƾ���ѧ'],
    ['6', '�����ƾ���ѧ'],
	['7', '�����ƾ���ѧ'],
    ['8', '�����ƾ���ѧ'],  
	['9', '�����ƾ���ѧ']
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
    alert('������һ��ͼƬʧ��!!');
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