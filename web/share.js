  const shareButton = document.querySelector('.share-modal');
        const overlay = document.querySelector('.overlay');
        const shareModal = document.querySelector('.share');
        const link = encodeURI(window.location.href);
        const msg = encodeURIComponent('Hey, I found this article');
        const title = encodeURIComponent('Article or Post Title Here');


        shareButton.addEventListener('click', () => {

            const twitter = document.querySelector('.twitter');
            twitter.href = `http://twitter.com/share?&url=${link}&text=${msg}&hashtags=javascript,programming`;

            const linkedIn = document.querySelector('.linkedin');
            linkedIn.href = `https://www.linkedin.com/sharing/share-offsite/?url=${link}`;

            const reddit = document.querySelector('.reddit');
            reddit.href = `http://www.reddit.com/submit?url=${link}&title=${title}`;

            const whatsapp = document.querySelector('.whatsapp');
            whatsapp.href = `https://api.whatsapp.com/send?text=${msg}: ${link}`;

            const telegram = document.querySelector('.telegram');
            telegram.href = `https://telegram.me/share/url?url=${link}&text=${msg}`;

            const instagram = document.querySelector('.instagram');
            instagram.href = `https://www.instagram.com/?url=${link}`;
            overlay.classList.add('show-share');
            shareModal.classList.add('show-share');




        });
        overlay.addEventListener('click', () => {
            overlay.classList.remove('show-share');
            shareModal.classList.remove('show-share');
        });


