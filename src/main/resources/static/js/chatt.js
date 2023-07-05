let ws;
const mid = getId('mid');
const btnLogin = getId('btnLogin');
const btnSend = getId('btnSend');
const talk = getId('talk');
const msg = getId('msg');

// 전송 데이터(JSON)
const data = {};

function getId(id) {
    return document.getElementById(id);
}

btnLogin.onclick = function() {
    // 서버와 webSocket 연결
    ws = new WebSocket("ws://" + location.host + "/chatt");

    // 서버에서 받은 메세지 처리
    ws.onmessage = function(msg) {
        const data = JSON.parse(msg.data);
        let css;

        if (data.mid === mid.value) {
            css = 'class=me';
        } else {
            css = 'class=other';
        }

        const item = `<div ${css} >
		                <span><b>${data.mid}</b></span> [ ${data.date} ]<br/>
                      <span>${data.msg}</span>
						</div>`;

        talk.innerHTML += item;

        // 스크롤바 하단으로 이동
        talk.scrollTop=talk.scrollHeight;
    }
}

// 엔터 클릭시 send함수 실행
msg.onkeyup = function(ev) {
    if (ev.keyCode === 13) {
        send();
    }
}

// 버튼 클릭시 send함수 실행
btnSend.onclick = function() {
    send();
}

function send() {
    if (msg.value.trim() !== '') {
        data.mid = getId('mid').value;
        data.msg = msg.value;
        data.date = new Date().toLocaleString();
        const temp = JSON.stringify(data);
        ws.send(temp);
    }

    msg.value = '';
}