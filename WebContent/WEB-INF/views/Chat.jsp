<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Assistant</title>
        <meta charset="UTF-8" />
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
        <style>
            html,body
			{
			    padding:0;
			    margin:0;
			    max-width:100%;
			    user-select:none;
			    -ms-user-select:none;
			    -moz-user-select:none;
			  
			  
			}
			
			
			.nice-font
			{
			    font-family:'Josefin Sans',sans-serif;
			}
			
			header
			{
			      text-align:center;
			}
			
			main
			{
			    padding:10px;
			    margin-bottom:50px;
			}
			
			footer #command
			{
			    position:fixed;
			    bottom:0;
			    width:100%;
			    padding:7px 7px;
			    padding-right:7px;
			    margin-bottom:5px;
			    border-radius:20px;
			    border:0.5px solid #9e9e9e50;
			    box-sizing:border-box ;
			    background-color:#fff;
			   
			}
			
			#command input
			{
			    display:block;
			    width:75%;
			   
			   
			}
			
			#command input,#command button
			{
			    float:left;
			    padding:10px 15px;
			    border:0;
			    outline:0;
			}
			
			button
			{
			    background-color:#1e88e5;
			    color:#fff;
			    border-radius:20px;
			    font-weight:300;
			   
			   
			}
			
			.row
			{
			     width:100%;
			     margin-bottom:10px;
			     display:block;
			}
			.row::after{
			      content: "";
			    display: table;
			    clear: both;
			}
			
			.chat
			{
			    border:0.7px solid #9e9e9e50;
			    word-wrap:break-word;
			    background-color:#fff;
			    border-radius:20px;
			    color:#333;
			    padding:10px 20px;
			    display:inline-block 
			}
			
			.question
			{
			    float:right;
			    background-color:#1e88e5;
			    color:#fff;
			    border-color:rgba(0,0,200,0.1);
			}
			
			.answer
			{
			    float:left;
			}
			

        </style>
    </head>
    <body>
        <header>
            <h1 class="nice-font" >Prashanth Bank's(Virtual Assistant)</h1>
        </header>
       
        <main class="nice-font">
          
        </main>
        <div id="last"></div>
        <footer>
            <div id="command">
                <input placeholder="Ask me something ..." type="text" />
                <button class="nice-font">Ask</button>
            </div>
        </footer>
        <script>
                    /*

        Things you can ask to GK:

        # What's your name ?

        # What's my name ?

        # Good morning

        # Good Night

        # Good Evening

        # Good Afternoon

        # 5+10

        # lol

        # Hello

        # Hi

        # What's the time ?

        # What's the date ?

        # best programming language

        ... and more.

        */

        const Message = () =>
        {
            alert("If you want to suggest your question and answer, feel free to comment. ");
        };

        const illegals = [
            "window",
            "document",
            "prompt",
            "alert",
            "confirm",
            "innerHTML",
            "style"
        
        ];

        const isLegal = string => {
        
            let Legal = true;

            illegals.forEach(illegal=>{
            
                if(string.indexOf(illegal) !== -1)
                {
                    Legal = false;
                }
            
            });
        
            return Legal;
        }

        const HtmlSpecialChars = function(string) {

            let escapedString = string;


            const len = HtmlSpecialChars.specialchars.length;

            for (let x = 0; x < len; x++) {
        
        escapedString = escapedString.replace( new RegExp(HtmlSpecialChars.specialchars[x][0], 'g'), HtmlSpecialChars.specialchars[x][1] );
                }
        
            return escapedString;
        };
            
        HtmlSpecialChars.specialchars = [
            [ '&', '&amp;' ],
            [ '<', '&lt;' ],
            [ '>', '&gt;' ],
            [ '"', '&quot;' ]
        ];

        const today = () =>
        {
        let date = new Date();
        
        return date.toLocaleDateString();
        
        }

        const now = () =>
        {
            let date = new Date();
        
            return date.toLocaleTimeString();
        }

        const Evaluate = expression =>
        {
            try
            {
                if(isLegal(expression))
                {
                
            
                    const result = eval(HtmlSpecialChars(expression));
                    return result;
            
                }
                else
                {
                    return "error";
                }
            }
        
            catch(err)
            {
                return "error";
            }
        }

        const Answers = {
            "hello" : "Hello %U% 😃. How can I help ? ",
      
            "hi" : "Hi %U% 😁",
            "hola" : "Hola amigo 😁",
            "my name" : "Your name is %U% &#10024;",
            "your name" : "My name is GK &#10024;",
            "GK" : "I'm here for you %U%",
            "date" : "The date is "+ today() + " in your region.",
            "time" : "The time is " + now() + " in your region.",
        
        
            "happy diwali" : "Happy Diwali to you too %U% 😃",
            "who is better google assistant or siri" : "No virtual assistant is better than me : )",
            "best programming language" : "the one that lacks curly braces 😁",
            "bye" : "Good bye. Hope we meet soon 😀",
            "good night" : "Good Night %U% 🌃",
            "good morning" : "Good Morning %U% 🌅",
            "good afternoon" : "Good Afternoon %U% ☀",
            "good evening" : "Good Evening %U% 🌇",
            "how are you" : "I am great !!! %U%. 😃",
            "you are cool" : "Thanks, I was born this way 😉",
            "i love you" : "I Love you too %U% 😊",
            "awesome" : "Glad, you liked it 😊", 
        "lol" : "Haha.. That was funny 😂",
        };


        const Notfound = "Sorry, I have no answers for that.";

        const Invalid = "Invalid Expression";


        const D = window.document;

        const element = selector => D.querySelector(selector);

        const Answer = (Main,User,Text) =>
        {
            let Flag = false;
        
            const Result = Evaluate(Text);
        
            text = Text.toLowerCase();
        
            Object.keys(Answers).forEach(key =>{
        
            if(!Flag)
            {
                if(text.indexOf(key) !== -1 )
                {
        
                addAnswer(
                    Main,
                    Answers[key].replace(
                    "%U%",
                    User
                    )
                );
                
                Flag = true;
            
            }
        
            else if(typeof Result == "number")
            {
                
                    addAnswer(
                        Main,
                        `${Text} equals ${Result}`
                    );
                    
                    Flag = true;
            
            }
            
            }
            
            });
        
            if(!Flag)
            {
                addAnswer(Main,Notfound);
            }
        
        
        };

        const addQuestion = (Main,text) =>
        {
            Main.innerHTML += `
                <div class="row">
                    <div class="chat question">${text}</div>
                </div>
            `;
        }

        const addAnswer = (Main,text) =>
        {
            Main.innerHTML += `
            <div class="row">
                <div class="chat answer">${text}</div>
            </div>
            `;
        }

        D.addEventListener("DOMContentLoaded",()=>{
            const Main = element("main");
        
            const Askbtn = element("button");
        
            const Question = element("input");
        
            const Lastdiv = element("#last");
        
            let User = prompt("Enter your name :");
        
            while(User == null  || User == "")
            {
        
                User = prompt("Your name is required for the assistant to work properly : ");
            
            }
        
            Question.focus();
        
        
            Askbtn.addEventListener("click",function(){
        
                const Text = Question.value;
            
                if(Text.length)
                {
            
                    addQuestion(Main, Text);
            
                    Question.value = "";
                
                    Answer(Main,User,Text);
                    
                    Lastdiv.scrollIntoView();
            
                }
            
            });
        
        
        
        
            addAnswer(Main,`Hello ${User}, I am BB. Thank you for using our bank, to provide more benefits we would like to have a quick survey about Bank Mortarium ?`);
        
        
            setTimeout(Message ,5000);
        });
        </script>
    </body>
</html>